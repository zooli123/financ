import Controller.CategoryHandler;

public class ManageCategories {
   
   public static void main(String[] args) {
      CategoryHandler cHandler = new CategoryHandler();
      cHandler.createFactory();

      /* Add few employee records in database */
      Integer empID1 = cHandler.addCategory("Költség", false);
      Integer empID2 = cHandler.addCategory("Bevétel", true);

      /* List down all the employees */
      cHandler.listCategories();

   }
   
 
   /* Method to UPDATE salary for an employee */
 /*  public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
		 session.update(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE an employee from the records */
/*   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }*/
}