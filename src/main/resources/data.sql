INSERT INTO transactions (id, transaction_id, from_account, to_account, amount, currency, status, timestamp, description, created_at)
VALUES 
('1', 'TXN-001', 'ACC-001', 'ACC-002', 1000.00, 'USD', 'COMPLETED', CURRENT_TIMESTAMP(), 'Payment for services', CURRENT_TIMESTAMP()),
('2', 'TXN-002', 'ACC-003', 'ACC-004', 2500.50, 'EUR', 'PENDING', CURRENT_TIMESTAMP(), 'International transfer', CURRENT_TIMESTAMP()),
('3', 'TXN-003', 'ACC-001', 'ACC-005', 500.00, 'USD', 'PROCESSING', CURRENT_TIMESTAMP(), 'Subscription payment', CURRENT_TIMESTAMP());