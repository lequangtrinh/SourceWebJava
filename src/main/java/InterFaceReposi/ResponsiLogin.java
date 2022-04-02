package InterFaceReposi;

import org.springframework.data.mongodb.repository.MongoRepository;

import Models.LoginModels;

public interface ResponsiLogin extends MongoRepository<LoginModels, String>{

}
