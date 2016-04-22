# language: en

Feature: only evoters can vote
	
Scenario: not e-voter
	Given the voter is not EVoter
	When the voter tries to access the system
	Then the system shows an error message 