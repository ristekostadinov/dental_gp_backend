update users
set password = '$argon2id$v=19$m=66536,t=2,p=1$crDUVbvjp9UHJ41SzdAB1w$U+sRziAdpyNRFSIetc7pGlIjMWeG6YdohP+GU5GN7ME'
where email = 'super@admin.com'
