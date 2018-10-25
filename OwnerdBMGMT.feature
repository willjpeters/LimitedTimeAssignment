Feature: Owner dB MGMT

Scenario: Access & Management

Given that the database of items can be accessed with a status code of 200
	When a new user is added to the system
	And their information is updated
	And then this entry may be deleted
		Then the error code 404 is returned, as this entry does not exist anymore