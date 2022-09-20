package com.example.AbhilashManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AbhilashManagement.entity.DocEntity;
import com.example.AbhilashManagement.exception.DocExist;


@Service
public class DocImpl implements DocService{
		
		@Autowired
		private com.example.AbhilashManagement.repo.DocRepo DocRepo;
		
		@Override
		public String addDoctor(DocEntity Doctor) {
			DocEntity clearDocData = DocRepo.findByName(Doctor.getName());
			if (clearDocData == null)
			{
				DocRepo.save(Doctor);
				return "New Doctor Added to the Database";}
			else 
				throw new DocExist ("Doctor Data Already Existed in the Database");
		}

		@Override
		public DocEntity updateDoctor(DocEntity Doctor, int id)
		{
			java.util.Optional<DocEntity> ed = DocRepo.findById(id);
			DocEntity eda = ed.get();
			eda.setName(Doctor.getName());
			eda.setSalary(Doctor.getSalary());
			eda.setSpecialist(Doctor.getSpecialist());
			DocRepo.save(eda);
			return eda;}
		
		@Override
		public List<DocEntity> getDoctor(){
			return DocRepo.findAllBySalary();}
		}	