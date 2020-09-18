# language-concat

Designed as a simple tool for calculating the concatenation of finite languages within the field of Automata Theory.

## Usage
If you have access to a bash shell simply run
    `./l-concat` 
Otherwise, you may run
    $ java -jar target/uberjar/language-concat-0.1.0-SNAPSHOT-standalone.jar $

## Options
Either of these may be run with or without command-line arguments. If you supply
command-line arguments, please list the elements of the language you are specifying, separated by spaces, followed by the number of concatenations, for example, to calculate L² from L = {a, ab}
    $ ./l-concat a ab 2 $

## Examples
    $ ./l-concat a ab ba bbb 3 $
    $ L³= {aaa, abaa, baaa, bbbaa,
     aaba, ababa, baaba, bbbaba,
     abaa, abbaa, babaa, bbbbaa,
     abbba, abbbba, babbba, bbbbbba,
     aaab, abaab, baaab, bbbaab,
     aabab, ababab, baabab, bbbabab,
     abaab, abbaab, babaab, bbbbaab,
     abbbab, abbbbab, babbbab, bbbbbbab,
     aaba, ababa, baaba, bbbaba,
     aabba, ababba, baabba, bbbabba,
     ababa, abbaba, bababa, bbbbaba,
     abbbba, abbbbba, babbbba, bbbbbbba,
     aabbb, ababbb, baabbb, bbbabbb,
     aabbbb, ababbbb, baabbbb, bbbabbbb,
     ababbb, abbabbb, bababbb, bbbbabbb,
     abbbbbb, abbbbbbb, babbbbbb, bbbbbbbbb}
 and has size: 64 $

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
