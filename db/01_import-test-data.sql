INSERT INTO menu(name, description, price, spice, is_gluten_free) VALUES ('Cake', 'It''s very good', 5, 0, TRUE);
INSERT INTO menu(name, description, price, spice, is_gluten_free) VALUES ('Pie',  'It''s very delicious', 2, 0, FALSE);

/*
 Passwords can be generated in mac or linux shell like so (where 123 is the salt
 and qwerty is the plaintext password):

  $ echo -n "123qwerty" | openssl dgst -sha512 | openssl enc -base64
*/

INSERT INTO user_account(username, hs512_password, salt) VALUES ('andrew', /*qwerty*/'MTdkYjk4YWVlZjUzZGRlN2NlMWMxYjlmNGUyMjY5MTZiZDQ4YWFkY2E4MDU1YTNj
OGYwN2IzMDdkMTdmZDhhZjdkYTg3OWZjMWNkYjI0ZjBmNWQzOGU0ODAxMDkxNWU1
ODNmNjE1MTcyN2JkYTI1YjlkZTI2MTFjZDQ0Y2MxNDgK', '0');
INSERT INTO user_account(username, hs512_password, salt) VALUES ('george', /*asdf*/'ODQxOWZhZTg5Yzk0OTVmMmYxNzJmZGY3NjU0M2E3MTJjYWU2OTg5ZTNkMjQ2ZWJm
MWUzMDM2ZmFlMGVmMTVhYjUzMmViNTg5NWNmYjcxZTRlMmQ5NjYzNWE0NmM0ZmRk
ZjRmZmI3NGUwZjYwZTZiMWM5ZWFjNWZhNWVmY2MzMmUK', '0');

