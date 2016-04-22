# language: en

Feature: data to access the system must be correct

Scenario: invalid nif
	Given the nif it does not exist
	When the voter introduces the nif and password
	Then the program shows an error