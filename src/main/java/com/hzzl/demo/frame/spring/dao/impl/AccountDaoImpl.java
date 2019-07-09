package com.hzzl.demo.frame.spring.dao.impl;

import com.hzzl.demo.frame.spring.dao.AccountDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
@Repository("accountDao")
@ComponentScan
public class AccountDaoImpl implements AccountDao
{
    @Override
    public void saveAccount()
    {
        System.out.println("保存了账户");
    }

    public static void main(String[] args)
    {
        Repository annotation = AccountDaoImpl.class.getAnnotation(Repository.class);
        String value = annotation.value();
        System.out.println(value);
    }


}
