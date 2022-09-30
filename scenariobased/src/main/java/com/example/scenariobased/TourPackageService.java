package com.example.scenariobased;

import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class TourPackageService {
	private TourPackageRepository tourPackageRepository;

	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}
	
	
	public List<TourPackage> listAllPackages(){
		return tourPackageRepository.findAll();
	}
	
	public void addPackage(TourPackage tourPackage) {
		tourPackageRepository.save(tourPackage);
	}
	
	public TourPackage findPackage(String src, String dest) {
		TourPackage pkg = tourPackageRepository.findBySourceAndDestination(src,dest);
		System.out.println(pkg);
		
		int days;
		double basic_fare,discount=0,package_cost;
		
		Scanner scanner = new Scanner(System.in);
		days = scanner.nextInt();
		basic_fare = pkg.getBasic_fare();
		
		 if (days<=5){
             discount = 0;
         } else if (days>5 && days<=8) {
             discount = 0.03;
         } else if (days>8 && days<=10) {
             discount = 0.05;
         } else if (days>10) {
             discount = 0.07;
         }

       
         package_cost = ((basic_fare*days)-(basic_fare*discount))+basic_fare*(1-discount)*0.12;
         
         System.out.println("travel Package  amount = " + package_cost);
		
		return pkg;
	}
}
