# New-cpsc-410

The purpose of EasyEditor is help NOT LaTeX expert to create LaTeX document from natural English. And then, user can copy our output to Overleaf in order to form PDF.

EBNF

PROGRAM := STATEMENT*;\
STATEMENT := SET | CREATE | ADD | PRESENT;\
SET := "SET ", HEADER | AUTHOR | DATE | TITLE;\
HEADER := "HEADER ", '"', STRING, '"';\
AUTHOR := "AUTHOR ", '"', STRING, '"';\
DATE := "DATE ", '"', DATE_STRING, '"';\
TITLE := "TITLE OF ", SECTION_ID, '"', STRING, '"';\
CREATE := "CREATE ", SECTION | STRING_CONTENT | LIST | SUPER_STRING;\
SECTION := "SECTION CALLED ", SECTION_ID;\
STRING_CONTENT := "STRING ", '"', STRING, '"', " CALLED ", STRING_ID;\
LIST := "LIST ", '"', ITEM*, '"', " CALLED ", LIST_ID;\
ITEM := [','],  STRING\
SUPER_STRING := "SUPER STRING ", '"', SUPER_STRING_CONTENT, '"', " CALLED ", STRING_ID;\
ADD := "ADD ", LIST_ID | SECTION_ID , " TO ", SECTION_ID;\
PRESENT := "PRESENT ", SECTION_ID*;\

PROGRAM must contain one HEADER\
PROGRAM at most contain one AUTHOR\
PROGRAM at most contain one DATE\
SET TITLE statement's SECTION_ID must has been created by CREATE SECTION statement\
format of DATE_STRING is DD/MM/YYYY\
format of SUPER_STRING_CONTENT is "[STRING*] [COLOR1]STRING2 [COLOR2]STRING3 [STRING*]", so color of STRING2 change to the color assign by COLOR1, color of STRING3 change to the color assign by COLOR2.\
ADD statement's LIST_ID or SECTION_ID must has been created by CREATE LIST or SECTION statement\
PRESENT statement's SECTION_ID must has been created by CREATE SECTION statement\

Example input:
![alt text](https://github.com/ZelinTian/New-cpsc-410/blob/master/figs/input.png)
