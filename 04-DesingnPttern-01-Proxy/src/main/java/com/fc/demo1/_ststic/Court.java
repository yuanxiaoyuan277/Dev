package com.fc.demo1._ststic;

import org.junit.Test;

public class Court {
    @Test
    public void  test(){
        //原告击鼓鸣冤
        Parties parties = new Parties();

        Lawyer lawyer = new Lawyer(parties);

        lawyer.submit();
        lawyer.defend();

    }
}
