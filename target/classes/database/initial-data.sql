INSERT INTO LICENSE (id, nr, name, termdays, price, description) VALUES
('acf49189-e872-48b0-949e-63d455f4fd86', 1, 'Norunu ezeras', 2, 1.6, '2 dienu leidimas zvejoti Norunu ez.'),
('7a580a64-a414-40dc-8861-52aa79ff2259', 2, 'Ilgio ezeras', 2, 3.6, '2 dienu leidimas zvejoti Ilgio ez.'),
('7a580a64-a414-40dc-8861-52aa79ff2251', 3,  'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2252', 4, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2253', 5, 'Norunu ezeras', 2, 1.6, '2 dienu leidimas zvejoti Norunu ez.'),
('7a580a64-a414-40dc-8861-52aa79ff2254', 6, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2255', 7, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2256', 8, 'Norunu ezeras', 2, 1.6, '2 dienu leidimas zvejoti Norunu ez.'),
('7a580a64-a414-40dc-8861-52aa79ff2257', 9, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2217', 10, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere'),
('7a580a64-a414-40dc-8861-52aa79ff2227', 11, 'Ilgio ezeras', 2, 3.6, '2 dienu leidimas zvejoti Ilgio ez.'),
('7a580a64-a414-40dc-8861-52aa79ff1227', 12, 'Norunu ezeras', 2, 1.6, '2 dienu leidimas zvejoti Norunu ez.'),
('7a580a64-a414-40dc-8861-52aa79ff3227', 13, 'Ilgio ezeras', 2, 3.6, '2 dienu leidimas zvejoti Ilgio ez.'),
('7a580a64-a414-40dc-8861-52aa79ff4227', 14, 'Vabalio ezeras', 1, 14.5, '1 dienos leidimas zvejoti Vabalio ezere');

INSERT INTO AREA (id, name, dayprice, monthprice, yearprice) VALUES
('acf49189-e872-48bf-949e-63d455f4fd86', 'Norunu ezeras', 1.6, 5.6, 24.5),
('7a580a64-a414-40dc-8861-52aa79ff2259', 'Ilgio ezeras', 3.6, 33.6, 98),
('7a580a64-a414-40dc-8461-52aa79ff2259', 'Kauno marios', 1.6, 5.6, 24.5),
('7a580a64-a414-40dd-8861-52aa79ff2251', 'Vabalio ezeras', 15.9, 112.9, 334.9);

INSERT INTO USERS (id, username, password, name, surname) VALUES
('acf49189-e872-48b0-949e-63d455f4fd86', 'user',
 '{bcrypt}$2y$12$Asaa8kGQMLq5IQ2LNb2VEeF6zKX4larg/rvALtrzLlJhczyl6teWC', 'Vardenis', 'Pavardenis'), /*pass*/
('7a580a64-a414-40dc-8861-52aa79ff2258', 'admin',
 '{bcrypt}$2y$12$RZ77B8lWhj..N1EA5Z2Q5.LnQ5YcwjhNaA13EljO6BvGMVeQeD4yO', 'Adminas', 'Adminauskas'); /*admin*/

INSERT INTO ROLES (id, name) VALUES
('acf49189-e872-48b0-949e-63d455f4fd86', 'USER'),
('7a580a64-a414-40dc-8861-52aa79ff2258', 'ADMIN');

INSERT INTO USERS_ROLES (user_id, roles_id) VALUES
('acf49189-e872-48b0-949e-63d455f4fd86', 'acf49189-e872-48b0-949e-63d455f4fd86'), /* user -> USER ROLE */
('7a580a64-a414-40dc-8861-52aa79ff2258', 'acf49189-e872-48b0-949e-63d455f4fd86'),
('7a580a64-a414-40dc-8861-52aa79ff2258', '7a580a64-a414-40dc-8861-52aa79ff2258'); /* admin -> USER, ADMIN ROLES */


