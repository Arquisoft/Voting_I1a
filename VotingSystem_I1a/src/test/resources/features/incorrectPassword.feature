# language: en

Feature: data to access the system must be correct

Scenario: incorrect password
	Given the nif suppose it exists
	When the voter introduces a wrong password
	Then the system shows an error message

