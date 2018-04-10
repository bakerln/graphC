package com.test.service;

import com.test.dao.StaffDao;
import com.test.dto.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiNan on 2018-04-10.
 * Description:
 */
@Service
public class StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add() {
        Staff staff = new Staff();
        staff.setStatus(123);
        staff.setId(21124124);
        staffDao.add(staff);

        Staff staff2 = new Staff();
        staff2.setStatus(0);
        staff.setId(23);
        staffDao.add(staff2);
    }
}
