package com.lijo.studentmanagement.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name = "guardian_name")
	),
	@AttributeOverride(
			name = "email",
			column = @Column(name = "guardian_email")
	),
	@AttributeOverride(
			name = "mobile",
			column = @Column(name = "guardian_mobile")
	),
})
public class Guardian {
  @NotBlank(message = "This is required")
  private String name;
  @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;
  private String mobile;
}
