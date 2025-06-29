package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.RoleDto;
import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;

public interface UserService {

    UserDto addUser(UserRegisterDto userRegisterDto);

    UserDto findUserByName(String userName);

    UserDto loginUser();

    UserDto deleteUser(String userName);

    UserDto updateUser(String userName, UserUpdateDto userUpdateDto);

    RoleDto addRole(String userName, String role);

    RoleDto deleteRole(String userName, String role);

    void changePassword();

}
