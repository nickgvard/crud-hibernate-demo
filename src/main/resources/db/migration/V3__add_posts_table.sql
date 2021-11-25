CREATE TABLE post
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    writer_id BIGINT,
    post_status_id INT NOT NULL,
    content VARCHAR(512) NOT NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP
)