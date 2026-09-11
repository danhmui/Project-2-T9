package com.javaweb.service.impl;

import com.javaweb.constant.SystemConstant;
import com.javaweb.converter.UserConverter;
import com.javaweb.dto.RegisterDTO;
import com.javaweb.dto.StaffResponseDTO;
import com.javaweb.entity.*;
import com.javaweb.model.dto.PasswordDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.exception.MyException;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.RoleRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, Long status) {
        return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
    }

    @Override
    public List<UserDTO> getUsers(String searchValue, Pageable pageable) {
        Page<UserEntity> users = null;
        if (StringUtils.isNotBlank(searchValue)) {
            users = userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0L, pageable);
        } else {
            users = userRepository.findByStatusNot(0L, pageable);
        }
        List<UserEntity> newsEntities = users.getContent();
        List<UserDTO> result = new ArrayList<>();
        for (UserEntity userEntity : newsEntities) {
            UserDTO userDTO = userConverter.convertToDto(userEntity);
            userDTO.setRoleCode(userEntity.getRoles().get(0).getCode());
            result.add(userDTO);
        }
        return result;
    }



    @Override
    public List<UserDTO> getAllUsers(Pageable pageable) {
        List<UserEntity> userEntities = userRepository.getAllUsers(pageable);
        List<UserDTO> results = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            UserDTO userDTO = userConverter.convertToDto(userEntity);
            userDTO.setRoleCode(userEntity.getRoles().get(0).getCode());
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public int countTotalItems() {
        return userRepository.countTotalItem();
    }



    @Override
    public Map<Long, String> getListStaff() {
        Map<Long, String> listStaff = new LinkedHashMap<>();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1L, "STAFF");
        for(UserEntity userEntity : staffs){
            listStaff.put(userEntity.getId(), userEntity.getFullName());
        }
        return listStaff;
    }

    @Override
    public List<StaffResponseDTO> getStaffsAssignmentBuilding(Long buildingId) {
        List<StaffResponseDTO> result = new ArrayList<>();
        // Tim tat ca nhan vien
        List<UserEntity> allStaffs = userRepository.findByStatusAndRoles_Code(1L, "STAFF");
        // Tim toa nha theo Id
        BuildingEntity buildingEntity = buildingRepository.findBuildingEntityById(buildingId);
        // Duyet toan bo nhan vien de them checked
        List<AssignmentBuildingEntity> assignStaffs = buildingEntity != null ? buildingEntity.getAssignmentBuildingEntities() : new ArrayList<>();
        for(UserEntity userEntity : allStaffs){
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setId(userEntity.getId());
            staffResponseDTO.setFullName(userEntity.getFullName());
            staffResponseDTO.setChecked("");

            for(AssignmentBuildingEntity  assignmentBuildingEntity : assignStaffs){
                if(assignmentBuildingEntity.getStaffId().equals(userEntity.getId())){
                    staffResponseDTO.setChecked("checked");
                    break;
                }
            }
            result.add(staffResponseDTO);
        }
        return result;
    }

    @Override
    public List<StaffResponseDTO> getStaffsAssignmentCustomer(Long customerId) {
        List<StaffResponseDTO> result = new ArrayList<>();
        List<UserEntity> allStaffs = userRepository.findByStatusAndRoles_Code(1L, "STAFF");
        CustomerEntity customerEntity = customerRepository.findCustomerEntityById(customerId);
        List<UserEntity> listStaffs = customerEntity != null ? customerEntity.getUserEntities() : new ArrayList<>();
        for (UserEntity userEntity : allStaffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(userEntity.getFullName());
            staffResponseDTO.setUserName(userEntity.getUserName());
            staffResponseDTO.setId(userEntity.getId());
            staffResponseDTO.setChecked("");
            for (UserEntity it : listStaffs) {
                if(it.getId().equals(userEntity.getId())){
                    staffResponseDTO.setChecked("checked");
                    break;
                }
            }
            result.add(staffResponseDTO);
        }
        return result;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) throws MyException {
        if(!registerDTO.getConfirmPassword().equals(registerDTO.getPassWord()))
            throw new MyException("Mật khẩu xác nhận không trùng khớp !");
        if(userRepository.existsByUserName(registerDTO.getUserName()))
            throw new MyException("Username đã tồn tại !");
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(registerDTO.getFullName());
        userEntity.setUserName(registerDTO.getUserName());
        userEntity.setPassword(passwordEncoder.encode(registerDTO.getPassWord()));
        userEntity.setStatus(1L);
        RoleEntity roleEntity = roleRepository.findOneByCode("STAFF");
        List<RoleEntity> roleEntities = new ArrayList<>();
        roleEntities.add(roleEntity);
        userEntity.setRoles(roleEntities);
        userRepository.save(userEntity);
        return userConverter.convertToDto(userEntity);
    }


    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        if (StringUtils.isNotBlank(searchValue)) {
            totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0L);
        } else {
            totalItem = (int) userRepository.countByStatusNot(0L);
        }
        return totalItem;
    }

    @Override
    public UserDTO findOneByUserName(String userName) {
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(long id) {
        UserEntity entity = userRepository.findById(id).get();
        List<RoleEntity> roles = entity.getRoles();
        UserDTO dto = userConverter.convertToDto(entity);
        roles.forEach(item -> {
            dto.setRoleCode(item.getCode());
        });
        return dto;
    }

    @Override
    @Transactional
    public UserDTO insert(UserDTO newUser) {
        RoleEntity role = roleRepository.findOneByCode(newUser.getRoleCode());
        UserEntity userEntity = userConverter.convertToEntity(newUser);
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setStatus(1L);
        userEntity.setPassword(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO updateUser) {
        RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
        UserEntity oldUser = userRepository.findById(id).get();
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setUserName(oldUser.getUserName());
        userEntity.setStatus(oldUser.getStatus());
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPassword(oldUser.getPassword());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void updatePassword(long id, PasswordDTO passwordDTO) throws MyException {
        UserEntity user = userRepository.findById(id).get();
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new MyException(SystemConstant.CHANGE_PASSWORD_FAIL);
        }
    }

    @Override
    @Transactional
    public UserDTO resetPassword(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setPassword(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOneByUserName(username);
        oldUser.setFullName(updateUser.getFullName());
        return userConverter.convertToDto(userRepository.save(oldUser));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (Long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            userEntity.setStatus(0L);
            userRepository.save(userEntity);
        }
    }
}
