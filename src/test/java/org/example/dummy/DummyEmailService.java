package org.example.dummy;

import dummy.EmailService;

public class DummyEmailService implements EmailService {
    @Override
    // email service ka as such koi use nhi test case mai isliye under kuch toh bhi(sout) likh diya
    // emailservice is method ko call karega hi nhi vo toh contructor mai email service daalna tha islye uska object
    // banana pada and object banane pr method implement krna tha toh kuch bhi likh dia
    public void sendEmail(String message) {
        System.out.println("Hello");
    }
}
