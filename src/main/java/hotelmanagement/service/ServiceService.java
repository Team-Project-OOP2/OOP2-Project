package hotelmanagement.service;

import hotelmanagement.model.Service;
import hotelmanagement.repository.ServiceRepository;

import java.util.List;

public class ServiceService {

    private static ServiceService instance;
    private final ServiceRepository serviceRepository = ServiceRepository.getInstance();

    private ServiceService() {}

    public static ServiceService getInstance() {
        if (instance == null) {
            instance = new ServiceService();
        }
        return instance;
    }

    public void addService(Service service) {
        serviceRepository.addService(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.getAllServices();
    }

    public void deleteService(String id) {
        serviceRepository.deleteService(id);
    }
}
