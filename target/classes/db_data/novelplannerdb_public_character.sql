insert into public.character (id, first_name, last_name, role, sex, father, mother)
values  (1, 'Homer',   'Simpson', 1, 0, null, null),
        (2, 'Marge',   'Simpson', 0, 1, null, null),
        (4, 'Bart',    'Simpson', 3, 0, 1, 2),
        (3, 'Lisa',    'Simpson', 2, 1, 1, 2),
        (5, 'Maggie',  'Simpson', 4, 1, 1, 2)
;
