package com.javaweb.service;

import com.javaweb.dto.RegisterDTO;
import com.javaweb.dto.StaffResponseDTO;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.PasswordDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.exception.MyException;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, Long status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws MyException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(long[] ids);
    List<UserDTO> getAllUsers(Pageable pageable);
    int countTotalItems();
    Map<Long, String> getListStaff();
    List<StaffResponseDTO> getStaffsAssignmentBuilding(Long buildingId);
    List<StaffResponseDTO> getStaffsAssignmentCustomer(Long customerId);
    UserDTO register(RegisterDTO registerDTO) throws MyException;
}
