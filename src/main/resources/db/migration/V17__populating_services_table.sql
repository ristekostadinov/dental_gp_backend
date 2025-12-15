-- Insert Orthodontic Services (category_id = 1)
INSERT INTO services (id, name, category_id) VALUES
                                                 (1, 'Braces (Traditional Metal Braces)', 1),
                                                 (2, 'Ceramic Braces', 1),
                                                 (3, 'Lingual Braces', 1),
                                                 (4, 'Clear Aligners', 1),
                                                 (5, 'Retainers', 1),
                                                 (6, 'Palatal Expanders', 1),
                                                 (7, 'Space Maintainers', 1),
                                                 (8, 'Orthodontic Headgear', 1),
                                                 (9, 'Interproximal Reduction (IPR)', 1),
                                                 (10, 'Bite Correction', 1),
                                                 (11, 'Orthodontic Evaluations and Monitoring', 1),
                                                 (12, 'Jaw Alignment and Orthognathic Surgery Coordination', 1),
                                                 (13, 'TMJ Disorder Support', 1);

-- Insert Endodontic Services (category_id = 2)
INSERT INTO services (id, name, category_id) VALUES
                                                 (14, 'Root Canal Treatment', 2),
                                                 (15, 'Endodontic Retreatment', 2),
                                                 (16, 'Apicoectomy (Surgical Root Procedure)', 2),
                                                 (17, 'Pulpotomy', 2),
                                                 (18, 'Pulpectomy', 2),
                                                 (19, 'Treatment of Dental Trauma', 2),
                                                 (20, 'Internal Bleaching of Discolored Teeth', 2),
                                                 (21, 'Cracked Tooth Diagnosis and Management', 2),
                                                 (22, 'Vital Pulp Therapy', 2),
                                                 (23, 'Periapical Surgery', 2);

-- Insert Periodontic Services (category_id = 3)
INSERT INTO services (id, name, category_id) VALUES
                                                 (24, 'Scaling and Root Planing (Deep Cleaning)', 3),
                                                 (25, 'Periodontal Maintenance', 3),
                                                 (26, 'Gum Grafting', 3),
                                                 (27, 'Crown Lengthening', 3),
                                                 (28, 'Guided Tissue Regeneration', 3),
                                                 (29, 'Periodontal Pocket Reduction Surgery', 3),
                                                 (30, 'Laser Gum Treatment', 3),
                                                 (31, 'Treatment of Gum Recession', 3),
                                                 (32, 'Dental Implants Related to Periodontal Care', 3),
                                                 (33, 'Periodontal Disease Diagnosis and Monitoring', 3);

-- Insert Prosthodontic Services (category_id = 4)
INSERT INTO services (id, name, category_id) VALUES
                                                 (34, 'Dental Crowns', 4),
                                                 (35, 'Dental Bridges', 4),
                                                 (36, 'Complete Dentures', 4),
                                                 (37, 'Partial Dentures', 4),
                                                 (38, 'Dental Implants and Restorations', 4),
                                                 (39, 'Full Mouth Reconstruction', 4),
                                                 (40, 'Veneers', 4),
                                                 (41, 'Implant-Supported Dentures', 4),
                                                 (42, 'Occlusal Bite Adjustment', 4),
                                                 (43, 'Maxillofacial Prosthetics', 4);

-- Oral and Maxillofacial Surgery (category_id = 5)
INSERT INTO services (id, name, category_id) VALUES
                                                 (44, 'Tooth Extractions (Including Wisdom Teeth)', 5),
                                                 (45, 'Orthognathic (Corrective Jaw) Surgery', 5),
                                                 (46, 'Facial Trauma Surgery', 5),
                                                 (47, 'Cyst or Tumor Removal', 5),
                                                 (48, 'TMJ Surgery', 5),
                                                 (49, 'Bone Grafting', 5),
                                                 (50, 'Sinus Lift Surgery', 5),
                                                 (51, 'Surgical Treatment of Oral Cancer', 5),
                                                 (52, 'Frenectomy', 5),
                                                 (53, 'Pre-Prosthetic Surgery', 5);

-- Pediatric Dentistry (category_id = 6)
INSERT INTO services (id, name, category_id) VALUES
                                                 (54, 'Infant Oral Health Exams', 6),
                                                 (55, 'Preventive Dental Care (Cleanings, Fluoride)', 6),
                                                 (56, 'Sealants for Children', 6),
                                                 (57, 'Pulp Therapy for Primary Teeth', 6),
                                                 (58, 'Dental Fillings for Baby Teeth', 6),
                                                 (59, 'Interceptive Orthodontics', 6),
                                                 (60, 'Emergency Dental Care for Children', 6),
                                                 (61, 'Behavior Management and Sedation', 6),
                                                 (62, 'Monitoring of Oral Growth and Development', 6);

-- Oral and Maxillofacial Pathology (category_id = 7)
INSERT INTO services (id, name, category_id) VALUES
                                                 (63, 'Biopsy of Oral Lesions', 7),
                                                 (64, 'Diagnosis of Oral Cancers', 7),
                                                 (65, 'Histopathologic Examination of Tissues', 7),
                                                 (66, 'Management of Pre-cancerous Oral Conditions', 7),
                                                 (67, 'Oral Infection Diagnosis and Classification', 7);

-- Oral and Maxillofacial Radiology (category_id = 8)
INSERT INTO services (id, name, category_id) VALUES
                                                 (68, 'Interpretation of Dental X-Rays', 8),
                                                 (69, 'Cone Beam CT Imaging', 8),
                                                 (70, 'MRI and CT Review of Head and Neck Structures', 8),
                                                 (71, 'Radiologic Diagnosis of Jaw Lesions', 8),
                                                 (72, 'Digital Imaging for Implant Planning', 8);

-- Dental Public Health (category_id = 9)
INSERT INTO services (id, name, category_id) VALUES
                                                 (73, 'Community Oral Health Program Design', 9),
                                                 (74, 'Fluoridation Program Oversight', 9),
                                                 (75, 'Dental Health Education and Outreach', 9),
                                                 (76, 'Oral Disease Surveillance and Research', 9),
                                                 (77, 'Policy Development for Dental Access', 9);

-- Cosmetic Dentistry (category_id = 10)
INSERT INTO services (id, name, category_id) VALUES
                                                 (78, 'Teeth Whitening', 10),
                                                 (79, 'Porcelain Veneers', 10),
                                                 (80, 'Cosmetic Bonding', 10),
                                                 (81, 'Gum Contouring', 10),
                                                 (82, 'Smile Makeover', 10);

-- Implantology (category_id = 11)
INSERT INTO services (id, name, category_id) VALUES
                                                 (83, 'Dental Implant Placement', 11),
                                                 (84, 'Implant Restoration', 11),
                                                 (85, 'All-on-4 Implants', 11),
                                                 (86, 'Bone Grafting for Implants', 11),
                                                 (87, 'Sinus Lift for Implant Support', 11);

-- Geriatric Dentistry (category_id = 12)
INSERT INTO services (id, name, category_id) VALUES
                                                 (88, 'Oral Care for Medically Compromised Patients', 12),
                                                 (89, 'Denture Fitting and Maintenance for Seniors', 12),
                                                 (90, 'Treatment of Xerostomia (Dry Mouth)', 12),
                                                 (91, 'Management of Root Caries', 12),
                                                 (92, 'Comprehensive Oral Exams for Elderly Patients', 12);

-- Laser Dentistry (category_id = 13)
INSERT INTO services (id, name, category_id) VALUES
                                                 (93, 'Laser Gum Surgery', 13),
                                                 (94, 'Laser Teeth Whitening', 13),
                                                 (95, 'Laser Frenectomy', 13),
                                                 (96, 'Treatment of Canker Sores with Lasers', 13),
                                                 (97, 'Laser Bacterial Reduction Therapy', 13);