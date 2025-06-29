package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.RoleDto;
import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
   private final ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserRegisterDto userRegisterDto) {
        return null;
    }

    @Override
    public UserDto findUserByName(String userName) {
        return null;
    }

    @Override
    public UserDto loginUser() {
        return null;
    }

    @Override
    public UserDto deleteUser(String userName) {
        return null;
    }

    @Override
    public UserDto updateUser(String userName, UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public RoleDto addRole(String userName, String role) {
        return null;
    }

    @Override
    public RoleDto deleteRole(String userName, String role) {
        return null;
    }

    @Override
    public void changePassword() {

    }
}
