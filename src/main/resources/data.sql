insert into address (address_id, street, city, state, zip)
values (1, '800 Main St', 'Pewaukee', 'WI', '53072');

insert into address (address_id, street, city, state, zip)
values (2, '1250 W Wisconsin Ave', 'Milwaukee', 'WI', '53233');

insert into address (address_id, street, city, state, zip)
values (3, '3520 30th Ave', 'Kenosha', 'WI', '53144');

insert into address (address_id, street, city, state, zip)
values (4, '800 W Main St', 'Whitewater', 'WI', '53190');

insert into address (address_id, street, city, state, zip)
values (5, '1 E Jackson Blvd', 'Chicago', 'IL', '60604');

insert into address (address_id, street, city, state, zip)
values (6, '2625 W Baseline Rd', 'Tempe', 'AZ', '85283-1056');

insert into student (student_id, first_name, last_name, email, gpa, address_id, date_enrolled)
values (1, 'Stacy', 'Read', 'sread@wctc.edu', 3.8, 1, PARSEDATETIME('13 Sep 2015', 'dd MMM yyyy') );

insert into student (student_id, first_name, last_name, email, gpa, address_id, date_enrolled)
values (2, 'Matt', 'Green', 'mgreen@marquette.edu', 3.8, 2, PARSEDATETIME('07 Jul 2021', 'dd MMM yyyy') );

insert into student (student_id, first_name, last_name, email, gpa, address_id, date_enrolled)
values (3, 'Hello', 'Kitty', 'hkitty@uww.edu', 3.9, 4, PARSEDATETIME('27 Jan 2019', 'dd MMM yyyy') );

insert into student (student_id, first_name, last_name, email, gpa, address_id, date_enrolled)
values (4, 'Badtz', 'Maru', 'bmaru@uat.edu', 3.8, 1, PARSEDATETIME('05 May 2009', 'dd MMM yyyy') );

insert into student_language(student_id, language)
values (3, 'English');

insert into student_language(student_id, language)
values (3, 'Japanese');

insert into student_language(student_id, language)
values (4, 'English');

insert into student_language(student_id, language)
values (4, 'Japanese');

insert into student_language(student_id, language)
values (4, 'Korean');

insert into student_language(student_id, language)
values (1, 'English');

insert into student_language(student_id, language)
values (1, 'French');

insert into student_language(student_id, language)
values (2, 'English');

insert into student_language(student_id, language)
values (2, 'Gaelic');

insert into book (isbn, title, subtitle, author, publication_date, publisher, page_count, description, website)
values ('9781593275846', 'Eloquent JavaScript, Second Edition', 'A Modern Introduction to PrograMMing', 'Marijn Haverbeke',
        PARSEDATETIME('2014 12 14', 'yyyy MM dd'), 'No Starch Press', 472,
        'JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.',
        'http://eloquentjavascript.net/');

insert into book (isbn, title, author, publication_date, publisher, page_count, description, website)
values ('9781617298813', 'Spring Boot in Practice', 'Somnath Musib',
        PARSEDATETIME('2022 03 30', 'yyyy MM dd'), 'Manning', 480,
        'Go beyond the basics with Spring Boot! This practical guide presents dozens of relevant scenarios in a convenient problem-solution-discussion format.',
        'https://www.manning.com/books/spring-boot-in-practice');

insert into stock_purchase(symbol, price_per_share, shares, purchase_date)
 VALUES ( 'CCL', 25.44, 100, PARSEDATETIME('2021 09 25', 'yyyy MM dd') );

insert into stock_purchase(symbol, price_per_share, shares, purchase_date)
VALUES ( 'BAC', 42.14, 75, PARSEDATETIME('2021 09 22', 'yyyy MM dd') );

insert into stock_purchase(symbol, price_per_share, shares, purchase_date)
VALUES ( 'NKE', 149.59, 23, PARSEDATETIME('2021 09 23', 'yyyy MM dd') );

insert into stock_purchase(symbol, price_per_share, shares, purchase_date)
VALUES ( 'PFE', 43.94, 175, PARSEDATETIME('2021 09 21', 'yyyy MM dd') );

insert into stock_purchase(symbol, price_per_share, shares, purchase_date)
VALUES ( 'XOM', 57.59, 18, PARSEDATETIME('2021 09 24', 'yyyy MM dd') );