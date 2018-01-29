package com.magnetis;


import com.magnetis.domain.*;
import com.magnetis.repository.CategoryRepository;
import com.magnetis.repository.CompanyRepository;
import com.magnetis.repository.CustomerRepository;
import com.magnetis.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@EntityScan(
        basePackageClasses = {Application.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository productRepository, CustomerRepository customerRepository,
                                  CompanyRepository companyRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            Product fon = getProductAsFon();
            Category cat = getCategoryBeauty();
            categoryRepository.save(cat);
            fon.setCategory(cat);
            productRepository.save(fon);

            for (int i = 0; i < 3; i++) {
                Company c = getDummyCompany();
                c.setCategories(new ArrayList<Category>());

                c.getCategories().add(cat);
                companyRepository.save(c);
            }
            for (int i = 0; i < 10; i++) {
                Customer c = getDummyCustomer(i);
                ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();
                orders.add(getDummyOrder());
                customerRepository.save(c);
            }

        };
    }

    //Enable Global CORS support for the application
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/customer")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    private Customer getDummyCustomer(int i) {
        Customer c1 = new Customer();
        String[] array = {"Hello", "world", "DIC", "dream", "ali", "veli", "harun", "mahir", "eren", "ahmet"};
        Random ran = new Random();
        c1.setBirth(new Date());
        c1.setFirstName(array[ran.nextInt(array.length)]);
        c1.setLastName(array[ran.nextInt(array.length)]);
        c1.setPhoneNumber("53032873827");
        c1.setPoints(new Double(i));
        c1.setEMail(ran.nextLong() + c1.getFirstName() + "@" + c1.getLastName()+".com");
        c1.setPassword(c1.getPhoneNumber() + "X");

        return c1;
    }

    public CustomerOrder getDummyOrder() {
        CustomerOrder co = new CustomerOrder();
        co.setOrderAmount(new Random().nextDouble());
        co.setOrderDate(new Date());
        co.setProduct(getProductAsFon());
        return co;
    }

    public Product getProductAsFon() {
        Product fon = new Product();
        fon.setCost(new Random().nextDouble());
        fon.setImageThumbnailUrl("http://www.kuaforalemi.com/wp-content/uploads/2016/06/fon-makinesi-fiyatlari.jpg");
        fon.setImageUrl("http://www.kuaforalemi.com/wp-content/uploads/2016/06/fon-makinesi-fiyatlari.jpg");
        fon.setLongDesc("Saç fönü");
        fon.setShortDesc("Fön");
        fon.setVisible(true);
        return fon;
    }

    public Company getDummyCompany() {
        Company c = new Company();

        c.setCategories(new ArrayList<Category>());
        return c;
    }

    public Category getCategoryBeauty() {
        Category c = new Category();
        c.setName("Beauty");
        c.setProducts(new ArrayList<Product>());
        c.setVisible(true);
        return c;
    }
}
