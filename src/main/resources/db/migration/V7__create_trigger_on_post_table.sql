CREATE OR REPLACE FUNCTION add_post_status() RETURNS TRIGGER AS $$
    BEGIN
        IF TG_OP = 'INSERT' THEN
            UPDATE post
            SET post_status_id = 2
            WHERE id = NEW.id;
            RETURN NEW;
        END IF;
    END;
    $$ LANGUAGE plpgsql;

CREATE TRIGGER t_post_status
    AFTER INSERT ON post FOR EACH ROW EXECUTE PROCEDURE add_post_status();