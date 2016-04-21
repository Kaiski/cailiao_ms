package com.whut.cailiao.impl.dao.privilege;

import com.whut.cailiao.api.model.privilege.UserRole;

import java.util.List;

/**
 * Created by gammaniu on 16/4/21.
 */
public interface UserRoleDao {

    void createUserRoleMapEntry(UserRole userRole);

    List<UserRole> getUserRoleMapEntryByAccountId(String accountId);

    void deleteEntryByAccountId(String accountId);

    void deleteEntryByRoleId(int roleId);

}
