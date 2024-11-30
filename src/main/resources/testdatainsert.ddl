-- 프로젝트 삽입
INSERT INTO project (name, status) VALUES
                                       (' 웹 개발 프로젝트', 'ACTIVATION'),
                                       (' 모바일 앱 리디자인', 'ACTIVATION'),
                                       (' 마케팅 캠페인', 'DORMANT'),
                                       ('내부 도구 개발', 'END'),
                                       ('고객 지원 포털', 'ACTIVATION');

-- 프로젝트 멤버 삽입
INSERT INTO project_member (project_id, email, name, role) VALUES
                                                               (1, 'john.doe@company.com', '김철수', 'ADMIN'),
                                                               (1, 'sarah.smith@company.com', '이영희', 'MEMBER'),
                                                               (2, 'mike.johnson@company.com', '박민수', 'ADMIN'),
                                                               (2, 'emily.wang@company.com', '최지원', 'MEMBER'),
                                                               (3, 'alex.park@company.com', '정현준', 'ADMIN'),
                                                               (3, 'lisa.chen@company.com', '한서연', 'MEMBER'),
                                                               (4, 'david.kim@company.com', '윤성호', 'ADMIN'),
                                                               (4, 'rachel.lee@company.com', '강은지', 'MEMBER'),
                                                               (5, 'tom.harris@company.com', '임재혁', 'ADMIN'),
                                                               (5, 'jessica.brown@company.com', '조수민', 'MEMBER');

-- 마일스톤 삽입
INSERT INTO mile_stone (project_id, name) VALUES
                                              (1, '백엔드 개발'),
                                              (1, '프론트엔드 설계'),
                                              (2, 'UI/UX 조사'),
                                              (2, '프로토타입 개발'),
                                              (3, '전략 기획'),
                                              (3, '콘텐츠 제작'),
                                              (4, '초기 컨셉'),
                                              (4, '프로토타입 테스트'),
                                              (5, '요구사항 수집'),
                                              (5, '초기 개발');

-- 태그 삽입
INSERT INTO tag (project_id, name) VALUES
                                       (1, '백엔드'),
                                       (1, '프론트엔드'),
                                       (2, '모바일'),
                                       (2, '디자인'),
                                       (3, '마케팅'),
                                       (3, '전략'),
                                       (4, '내부 도구'),
                                       (4, '프로토타입'),
                                       (5, '고객 지원'),
                                       (5, '웹 포털');

-- 업무 삽입 (마일스톤과 1:1 관계 준수)
INSERT INTO task (project_id, mile_stone_id, project_member_id, tag_id, title, content) VALUES
                                                                                            (1, 1, 1, 1, '데이터베이스 스키마 설계', '웹 애플리케이션을 위한 포괄적인 데이터베이스 설계'),
                                                                                            (1, 2, 2, 2, '반응형 레이아웃 제작', '모바일 친화적인 반응형 웹 인터페이스 설계'),
                                                                                            (2, 3, 3, 3, '사용자 리서치', '사용자 인터뷰 및 요구사항 수집'),
                                                                                            (2, 4, 4, 4, '프로토타입 개발', '모바일 앱의 대화형 프로토타입 제작'),
                                                                                            (3, 5, 5, 5, '시장 분석', '포괄적인 시장 조사 실시'),
                                                                                            (3, 6, 6, 6, '콘텐츠 기획', '콘텐츠 캘린더 및 메시지 개발'),
                                                                                            (4, 7, 7, 7, '초기 컨셉 정의', '내부 도구의 초기 컨셉 및 기능 정의'),
                                                                                            (4, 8, 8, 8, '프로토타입 테스트', '개발된 프로토타입에 대한 철저한 테스트'),
                                                                                            (5, 9, 9, 9, '요구사항 수집', '고객 지원 포털의 상세 요구사항 정의'),
                                                                                            (5, 10, 10, 10, '초기 개발 착수', '고객 지원 포털의 초기 개발 단계 시작');

-- 댓글 삽입
INSERT INTO comment (task_id, author_id, content, created_at) VALUES
                                                                  (1, 1, '데이터베이스 스키마 작업 잘 진행되고 있습니다', CURRENT_TIMESTAMP),
                                                                  (1, 2, '더 자세한 사용자 권한 추가가 필요할 것 같습니다', CURRENT_TIMESTAMP),
                                                                  (2, 2, '반응형 디자인에 몇 가지 개선점이 있습니다', CURRENT_TIMESTAMP),
                                                                  (3, 3, '사용자 인터뷰에서 흥미로운 인사이트를 얻었습니다', CURRENT_TIMESTAMP),
                                                                  (4, 4, '프로토타입 디자인에 대한 초기 피드백 반영 필요', CURRENT_TIMESTAMP),
                                                                  (5, 5, '시장 분석 결과 중요한 트렌드 발견', CURRENT_TIMESTAMP),
                                                                  (6, 6, '콘텐츠 캘린더 초안 작성 완료', CURRENT_TIMESTAMP),
                                                                  (7, 7, '내부 도구의 핵심 기능 정의', CURRENT_TIMESTAMP),
                                                                  (8, 8, '프로토타입 테스트 결과 보고서 준비 중', CURRENT_TIMESTAMP),
                                                                  (9, 9, '고객 요구사항 초기 수집 완료', CURRENT_TIMESTAMP);