package com.example.AbhilashManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AbhilashManagement.entity.DocEntity;
import com.example.AbhilashManagement.exception.DocExist;

@Service
public interface DocService {
	
		
		public String addDoctor(DocEntity Doctor) throws DocExist;
		
		public List<DocEntity> getDoctor();
		
		public DocEntity updateDoctor(DocEntity Doctor, int id) ;
	}