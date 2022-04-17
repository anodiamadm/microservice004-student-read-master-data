# microservice004-student-read-master-data

### GET :: /api/master-data/
	boards :: List all boards - to populate dropdowns in the frontend
	levels :: List all levels - to populate dropdowns in the frontend
	subjects :: List all subjects - to populate dropdowns in the frontend

### GET :: api/
	board/(BigInt board_id) :: show board with board_id
	level/(BigInt level_id) :: show level with level_id
	subject/(BigInt subject_id) :: show subject with subject_id