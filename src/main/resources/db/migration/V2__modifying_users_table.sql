alter table users
    alter column first_name set not null,
    alter column last_name set not null,
    alter column email set not null,
    alter column username set not null,
    alter column password set not null,
    add constraint email_unique unique (email);