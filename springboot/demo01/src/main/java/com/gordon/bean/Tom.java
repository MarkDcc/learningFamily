package com.gordon.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:dongchen
 * @Date: 2022/11/30 21:43
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tom {
	@Autowired
	private User user;
	private String address;
}
