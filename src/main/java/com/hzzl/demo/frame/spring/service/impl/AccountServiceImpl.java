package com.hzzl.demo.frame.spring.service.impl;

import com.hzzl.demo.frame.spring.dao.AccountDao;
import com.hzzl.demo.frame.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
@Service("accountService")
@ComponentScan
public class AccountServiceImpl implements AccountService
{
//    private AccountDao accountDao = new AccountDaoImpl();//此处的依赖关系有待解决

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount()
    {
        accountDao.saveAccount();
    }
}
