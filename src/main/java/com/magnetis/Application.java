package com.magnetis;


import com.magnetis.domain.*;
import com.magnetis.repository.*;
import com.magnetis.util.RandomString;
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
    public CommandLineRunner demo(ProductRepository productRepository, UserRepository userRepository,
                                  CompanyRepository companyRepository, CategoryRepository categoryRepository,
                                  OrderRepository orderRepository, ContentRepository contentRepository) {
        return (args) -> {
            Product fon = getProductAsFon();
            Category cat = getCategoryBeauty();
            categoryRepository.save(cat);
            fon.setCategory(cat);
            productRepository.save(fon);

            for (int i = 0; i < 3; i++) {
                Company c = getDummyCompany();
                User usr = getDummyCustomer(i);
                userRepository.save(usr);
                c.setOwner(usr);
                companyRepository.save(c);
            }
            for (int i = 0; i < 20; i++) {
                User c = getDummyCustomer(i);
                ArrayList<UserOrder> orders = new ArrayList<UserOrder>();
                UserOrder uo = getDummyOrder();
                uo.setProduct(fon);
                orderRepository.save(uo);
                orders.add(uo);
                c.setOrders(orders);
                userRepository.save(c);
            }

            for (int i = 0; i < 20; i++) {
                Content c = getDummyContent();
                contentRepository.save(c);
            }

            for (int i = 0; i < 20; i++) {
                User c1 = getDummyCustomer(i);
                User c2 = getDummyCustomer(i + 30);
                userRepository.save(c1);
                userRepository.save(c2);

            }
        };
    }

    //Enable Global CORS support for the application
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "PUT")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    private User getDummyCustomer(int i) {
        User c1 = new User();
        String[] array = {"ali", "veli", "ahmet", "ayşe", "nefise", "murat", "semih", "sezin", "selma", "nadide", "yasemin", "haluk", "duru"};
        Random ran = new Random();
        c1.setBirth(new Date());
        c1.setFirstName(array[ran.nextInt(array.length)]);
        c1.setLastName(array[ran.nextInt(array.length)]);
        c1.setPhoneNumber("53" + new RandomString().generateRandomChars("0123456789", 8));
        c1.setPoints(new Double(i));
        c1.setEMail(new RandomString().generateRandomChars("0123456789", 3) + c1.getFirstName() + "@" + c1.getLastName() + ".com");
        c1.setPassword(c1.getPhoneNumber() + "X");

        return c1;
    }

    public UserOrder getDummyOrder() {
        UserOrder co = new UserOrder();
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
        fon.setName("FON");
        return fon;
    }

    public Company getDummyCompany() {
        Company c = new Company();

        c.setCompanyCode(new RandomString().createCompanyCode());
        c.setPointRatio(5);
        return c;
    }

    public Category getCategoryBeauty() {
        Category c = new Category();
        c.setName("Beauty");
        c.setVisible(true);
        return c;
    }

    public Content getDummyContent() {
        Content c = new Content();
        c.setContentType(ContentType.VIDEO);
        c.setName("hede" + new Random().nextInt());
        c.setInitialContent("https://www.youtube.com/watch?v=eBGSihZAyTg");
        c.setVisible(true);
        return c;
    }
}
