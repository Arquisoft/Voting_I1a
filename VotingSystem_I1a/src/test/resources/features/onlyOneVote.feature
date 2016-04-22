# language: en

Feature: Only one vote per voter

Scenario: checks if the voter has already voted
	Given the user is logged in and checked if he has voted
	When the user votes
	Then the voter is marked as already voted
