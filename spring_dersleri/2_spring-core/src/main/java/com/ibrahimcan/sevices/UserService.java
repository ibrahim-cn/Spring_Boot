package com.ibrahimcan.sevices;

import java.util.List;

import com.ibrahimcan.__spring_core.Person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserService {
	
	private List<Person> userList;
}
