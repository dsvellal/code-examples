Feature: Valid anagrams ouput SUCCESS

Scenario: Multiple valiud anagrams
	Given I have configuration of Validation before Preprocessing
	When I ask for anagram check on <firsttext> <secondtext>
	Then I see "SUCCESS" within 2ms of the previous code change

Examples:
| name | firsttext    |    secondtext    |
| different lengths | Simao | Simao|
| multiword | hello worldimao | word

.javas

@Step("When I ask for anagram check .* .*")
void StepImplementation(String firststring, String secondString)
{
	// call your command line
	// call unit logic
}	