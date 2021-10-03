package com.peterpreneur.budgetingapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.peterpreneur.budgetingapp.domain.User;
import com.peterpreneur.budgetingapp.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		User user = userRepo.findByUsername(username);
		
		if (user == null)
			throw new UsernameNotFoundException("User does not exist!");
		
		return new SecurityUser(user);
	}

}
