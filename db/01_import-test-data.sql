INSERT INTO menu(name, description, price, spice, is_gluten_free) VALUES ('Cake', 'It''s very good', 5, 0, TRUE);
INSERT INTO menu(name, description, price, spice, is_gluten_free) VALUES ('Pie',  'It''s very delicious', 2, 0, FALSE);

/*
 Passwords can be generated in mac or linux shell like so (where 123 is the salt
 and qwerty is the plaintext password):

  $ echo -n "123qwerty" | openssl dgst -sha512
*/

INSERT INTO user_account(username, hs512_password, salt) VALUES ('andrew', /*qwerty*/'17db98aeef53dde7ce1c1b9f4e226916bd48aadca8055a3c8f07b307d17fd8af7da879fc1cdb24f0f5d38e48010915e583f6151727bda25b9de2611cd44cc148', '0');
INSERT INTO user_account(username, hs512_password, salt) VALUES ('george', /*asdf*/  '8419fae89c9495f2f172fdf76543a712cae6989e3d246ebf1e3036fae0ef15ab532eb5895cfb71e4e2d96635a46c4fddf4ffb74e0f60e6b1c9eac5fa5efcc32e', '0');

