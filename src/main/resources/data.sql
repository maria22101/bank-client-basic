INSERT INTO `employers` (`name`, `address`) VALUES ('Mars Inc', '08900 Netherlands, Rotterdam, Balm Str');
INSERT INTO `employers` (`name`, `address`) VALUES ('Unilever Source', '07655 Great Britain, Yorkshire');
INSERT INTO `employers` (`name`, `address`) VALUES ('PG global', '02134 CA USA');

INSERT INTO `customers` (`name`, `email`, `age`) VALUES ('Mari Lane', 'maln@gmail.com', 50);
INSERT INTO `customers` (`name`, `email`, `age`) VALUES ('Jason Brooks', 'jbro@gmail.com', 45);
INSERT INTO `customers` (`name`, `email`, `age`) VALUES ('Victoria Parker', 'viki@gmail.com', 25);
INSERT INTO `customers` (`name`, `email`, `age`) VALUES ('Jessica Weaver', 'jess@gmail.com', 28);
INSERT INTO `customers` (`name`, `email`, `age`) VALUES ('Anna-Maria Sanches', 'ans@gmail.com', 43);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('75120b9e-ff3c-4e8e-8066-9bc763169aba', 'UAH', 1);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('33fcd5da-941f-4378-80dd-2cc346a3b49c', 'USD', 1);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('14bb7f5d-2c2e-4593-9009-213f4f3145a2', 'EUR', 2);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('23b4ecb3-eacf-4299-815e-5acd111b0f9f', 'USD', 3);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('23ee6efc-5efa-4d2b-b2e0-61eced87ee25', 'USD', 3);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('6194e352-29f3-409b-a5a0-447972a53060', 'EUR', 4);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('2ba60913-e3cf-4476-9e26-189c289759da', 'EUR', 5);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('c3e978af-4fda-4354-952b-20fa43e5869a', 'USD', 5);

INSERT INTO `accounts` (`number`, `currency`, `customer_id`)
VALUES ('a5ca46ba-b7a6-4821-b800-4e56a30df79e', 'UAH', 5);

INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (1, 1);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (1, 2);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (2, 3);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (2, 4);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (2, 5);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (3, 1);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (3, 3);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (3, 4);
INSERT INTO `employers_customers` (`employer_id`, `customer_id`) VALUES (3, 5);