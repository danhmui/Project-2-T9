package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.dto.CustomerResponseDTO;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.enums.StatusCode;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.service.impl.TransactionService;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/admin/customer-list")
    public ModelAndView getCustomers(@ModelAttribute("modelSearch") CustomerSearchRequest params, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/customer/list");
        DisplayTagUtils.of(request, params);
        Long currentUserId = SecurityUtils.getPrincipal().getId();
        if(!SecurityUtils.getAuthorities().contains(SystemConstant.MANAGER_ROLE))
            params.setStaffId(currentUserId);
        List<CustomerResponseDTO> result = customerService.findAll(params, PageRequest.of(params.getPage() - 1, params.getMaxPageItems()));
        mav.addObject("customerList", result);
        params.setListResult(result);
        params.setTotalItem(customerService.countTotalItem());
        mav.addObject(SystemConstant.MODEL, params);
        //Lay danh sach tinh trang
        mav.addObject("statusList", StatusCode.getStatusMap());
        //Lay danh sach nhan vien quan ly
        Map<Long, String> staffList = userService.getListStaff();
        mav.addObject("staffList", staffList);
        return mav;
    }
    @GetMapping("/admin/customer-edit")
    public ModelAndView insertOrUpdateCustomer(@RequestParam(required = false) Long id){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        if(id != null){
            if(!SecurityUtils.getAuthorities().contains(SystemConstant.MANAGER_ROLE)){
                Long currentUserId = SecurityUtils.getPrincipal().getId();
                if(!customerRepository.existsByIdAndUserEntities_Id(id, currentUserId))
                    return new ModelAndView("redirect:/access-denied");
            }
        }
        mav.addObject("statusList", StatusCode.getStatusMap());
        if(id != null){
            CustomerDTO customerDTO = customerService.findCustomerByIdAndIsActive(id, true);
            mav.addObject("modelInsertOrUpdate", customerDTO);
            mav.addObject("mode", "update");
        }else{
            mav.addObject("modelInsertOrUpdate", new CustomerDTO());
            mav.addObject("mode", "insert");
        }
        mav.addObject("transactionList", TransactionType.getTransactionTypeMap());
        List<TransactionDTO> CSKHTransactions = transactionService.findAllByCodeAndCustomer(TransactionType.CSKH.toString(), id);
        List<TransactionDTO> DDXTransactions = transactionService.findAllByCodeAndCustomer(TransactionType.DDX.toString(), id);
        mav.addObject("CSKH", CSKHTransactions);
        mav.addObject("DDX", DDXTransactions);
        return mav;
    }
}
