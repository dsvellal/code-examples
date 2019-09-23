Feature: Check if a word or a phrase is an anagram of the subject word or phrase.

  Scenario Outline: Understand failure cases better
    When I ask if the word or phrase "<subject>" is an anagram of the word or phrase "<candidate>"
    Then I see a message - can not check for anagram because "<reason>"

    Examples: 
      | subject     | candidate   | reason                                         |
      | \\"         | this        | subject is not a word or phrase                |
      | #@          | this phrase | subject is not a word or phrase                |
      | that        | \\'         | candidate is not a word or phrase              |
      | that phrase | ~!          | candidate is not a word or phrase              |
      |             | that phrase | subject is blank                               |
      | this phrase |             | candidate is blank                             |
      |             |             | both subject and candidate are blank           |
      | ~!          | \\"         | subject and candidate are not words or phrases |
      | \\'         | #@          | subject and candidate are not words or phrases |

  Scenario Outline: Successfully identify anagrams and non-anagrams in both-directions
    When I ask if the word or phrase "<candidate>" is an anagram of the word or phrase "<subject>"
    Then I see a message "<candidate>" "<result>" an anagram of "<subject>"
    When I ask if the word or phrase "<subject>" is an anagram of the word or phrase "<candidate>"
    Then I see a message "<subject>" "<result>" an anagram of "<candidate>"

    Examples: 
      | subject     | candidate  | result |
      | this phrase | earthships | is     |
      | this phrase | earthship  | is not |
      | word        | drow       | is     |
      | word        | drows      | is not |
      | gut         | tug        | is     |
