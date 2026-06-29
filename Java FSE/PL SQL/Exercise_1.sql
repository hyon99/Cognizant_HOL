SET SERVEROUTPUT ON;

DECLARE
BEGIN
    -------------------------------------------------
    -- Scenario 1: Apply 1% Discount for Customers Above 60
    -------------------------------------------------
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Interest rate discount applied.');

    -------------------------------------------------
    -- Scenario 2: Promote Customers to VIP
    -------------------------------------------------
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('VIP status updated.');

    -------------------------------------------------
    -- Scenario 3: Loan Due Reminder
    -------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('Loans Due Within Next 30 Days:');

    FOR rec IN (
        SELECT c.Name, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: ' || rec.Name ||
            ' - Loan Due on ' || rec.DueDate
        );
    END LOOP;

    COMMIT;
END;
/