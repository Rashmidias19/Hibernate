package nativebootstrapping;

import nativebootstrapping.config.SessionFactoryConfig;
import nativebootstrapping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AppInitializer {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setId(1);
        customer.setName("Rashmi");
        customer.setAddress("Galle");
        customer.setSalary(20000.00);

       // save action
        Session saveSession=SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction= saveSession.beginTransaction();
        saveSession.save(customer);
        saveTransaction.commit();
        saveSession.close();


        //update
//        Session updateSession=SessionFactoryConfig
//                .getInstance().getSession();
//        Transaction updateTransaction=updateSession.beginTransaction();
//        Customer customer1=updateSession.get(Customer.class,1);
//        customer1.setSalary(50000.00);
//        updateSession.update(customer1);
//        updateTransaction.commit();
//        updateSession.close();

        //delete

//
//        Transaction deleteTransaction= deleteSession.beginTransaction();
//        Customer deleteCustomer=deleteSession.get(Customer.class,1);
//        deleteSession.delete(deleteCustomer);
//        deleteTransaction.commit();
//        deleteSession.close();

    }
}
