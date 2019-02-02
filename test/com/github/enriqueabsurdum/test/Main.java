package com.github.enriqueabsurdum.test;

import com.github.enriqueabsurdum.dao.BrandDaoImpl;
import com.github.enriqueabsurdum.dao.CityDaoImpl;
import com.github.enriqueabsurdum.dao.DepartmentDaoImpl;
import com.github.enriqueabsurdum.dao.EmployeeDaoImpl;
import com.github.enriqueabsurdum.dao.MobileDaoImpl;
import com.github.enriqueabsurdum.dao.MobilePlanDaoImpl;
import com.github.enriqueabsurdum.dao.PlanDaoImpl;
import com.github.enriqueabsurdum.dao.PlanTypeDaoImpl;
import com.github.enriqueabsurdum.dao.ProfileDaoImpl;
import com.github.enriqueabsurdum.dao.UserDaoImpl;
import com.github.enriqueabsurdum.database.DatabaseConnection;
import com.github.enriqueabsurdum.enums.OperatingSystem;
import com.github.enriqueabsurdum.models.Brand;
import com.github.enriqueabsurdum.models.City;
import com.github.enriqueabsurdum.models.Department;
import com.github.enriqueabsurdum.models.Employee;
import com.github.enriqueabsurdum.models.Mobile;
import com.github.enriqueabsurdum.models.MobilePlan;
import com.github.enriqueabsurdum.models.Plan;
import com.github.enriqueabsurdum.models.PlanType;
import com.github.enriqueabsurdum.models.Profile;
import com.github.enriqueabsurdum.models.User;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        for (OperatingSystem os: OperatingSystem.values()) {
//            System.out.println(os.getOperatingSystem());
//        }
//        Brand brand;
//        BrandDaoImpl daoBrand = new BrandDaoImpl();
//        List<Brand> brands = daoBrand.findAll();
//        System.out.println(brands);
//
//        brand = daoBrand.read(2);
//        System.out.println(brand);
//
//        Plan plan;
//        PlanDaoImpl daoPlan = new PlanDaoImpl();
//        plan = daoPlan.read(1);
//        System.out.println(plan);
//
//        List<Plan> plans = daoPlan.findAll();
//        System.out.println(plans);
//
//        MobileDaoImpl daoMobile = new MobileDaoImpl();
//        List<Mobile> mobiles = daoMobile.findAll();
//        System.out.println(mobiles);
//
//        System.out.println(daoMobile.read(1));
//        Mobile mobile = new Mobile(
//                1,
//                "351756051523999",
//                "Motorola",
//                "Moto C",
//                null,
//                "2 MP",
//                "5 MP",
//                null,
//                "Google Android",
//                true,
//                null,
//                null,
//                "52554212"
//        );
//        daoMobile.update(mobile);
//        Mobile mobile = new Mobile(
//                "1",
//                "Samsung",
//                "Enterprise",
//                null,
//                null,
//                null,
//                null,
//                "Google Android",
//                true,
//                null,
//                null,
//                "1"
//        );
//        daoMobile.create(mobile);
//        CityDaoImpl daoCity = new CityDaoImpl();
//        List<City> cities = daoCity.findAll();
//        System.out.println(cities);
//        System.out.println(daoCity.read(2));
//        System.out.println(daoCity.getByCity("Concepción"));
//        DepartmentDaoImpl daoDepartment = new DepartmentDaoImpl();
//        List<Department> departments = daoDepartment.findAll();
//        System.out.println(departments);
//        System.out.println(daoDepartment.read(2));
//        System.out.println(daoDepartment.getByDepartment("Administración base de datos"));
//        ProfileDaoImpl daoProfile = new ProfileDaoImpl();
//        List<Profile> profiles = daoProfile.findAll();
//        System.out.println(profiles);
//        EmployeeDaoImpl daoEmployee = new EmployeeDaoImpl();
//        List<Employee> employees = daoEmployee.findAll();
//        MobileDaoImpl daoMobile = new MobileDaoImpl();
//        Mobile mobile = daoMobile.read(12);
//        try {
//            Employee employee = new Employee(
//                    0,
//                    "1111112332",
//                    "1111112332",
//                    "1111113232",
//                    "Logística",
//                    "1111112332",
//                    "1111113232",
//                    "1111113232",
//                    "Santiago",
//                    "2019-09-12",
//                    mobile
//            );
//            daoEmployee.create(employee);
//        } catch (Exception e) {
//            System.out.println("Excepción: " + e.getMessage());
//        }
//        try {
//            UserDaoImpl daoUser = new UserDaoImpl();
//            User user = daoUser.getLogin("enrique.costa@at.com", "enrique.costa");
//            System.out.println(user);
//        } catch (Exception e) {
//            System.out.printf("Exception: %s\n", e.getMessage());
//        }
//        UserDaoImpl daoUser = new UserDaoImpl();
//        List<User> users = daoUser.findAll();
//        System.out.println(users);
//        User user = daoUser.read(2);
//        System.out.println(user);
//        PlanTypeDaoImpl daoPlanType = new PlanTypeDaoImpl();
//        List<PlanType> planTypes = daoPlanType.findAll();
//        System.out.println(planTypes);

//        MobileDaoImpl daoMobile = new MobileDaoImpl();
//        int i = daoMobile.readByImei("10").getId();
//        System.out.println(i);

        MobilePlanDaoImpl daoMobilePlan = new MobilePlanDaoImpl();
        List <MobilePlan> mobilePlans = daoMobilePlan.findByMobile(24);
        System.out.println(mobilePlans);
    }
}
