package se.lexicon.marketplaceapi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.entity.Ad;
import se.lexicon.marketplaceapi.entity.User;
import se.lexicon.marketplaceapi.repository.AdRepository;
import se.lexicon.marketplaceapi.repository.UserRepository;

@Component
public class MyCMDLineRunner implements CommandLineRunner {

    private UserRepository userRepository;

    private AdRepository adRepository;

    @Autowired
    public MyCMDLineRunner(UserRepository userRepository, AdRepository adRepository) {
        this.userRepository = userRepository;
        this.adRepository = adRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        User user = new User("go@aol.com", "password");
        Ad ad = new Ad("Title CMD","DEsc CMD");
        Ad ad1 = new Ad("Ad 2", "Desc 3");

        ad1.setUser(user);
        ad.setUser(user);


        userRepository.save(user);
        adRepository.save(ad);

         */


    }
}
