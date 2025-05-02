CREATE TABLE IF NOT EXISTS users (
  sbd VARCHAR(255) PRIMARY KEY,
  toan DOUBLE PRECISION,
  ngu_van DOUBLE PRECISION,
  ngoai_ngu DOUBLE PRECISION,
  vat_li DOUBLE PRECISION,
  hoa_hoc DOUBLE PRECISION,
  sinh_hoc DOUBLE PRECISION,
  lich_su DOUBLE PRECISION,
  dia_li DOUBLE PRECISION,
  gdcd DOUBLE PRECISION,
  ma_ngoai_ngu VARCHAR(255)
);

COPY users(sbd, toan, ngu_van, ngoai_ngu, vat_li, hoa_hoc, sinh_hoc, lich_su, dia_li, gdcd, ma_ngoai_ngu)
FROM '/docker-entrypoint-initdb.d/diem_thi_thpt_2024.csv'
DELIMITER ','
CSV HEADER;