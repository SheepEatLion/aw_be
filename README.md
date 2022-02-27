# ✍️ Anonymous Writers (익명의 작가들)
- 더 편하고 재밌는 기능들을 가진 웹 릴레이소설 사이트 !

## 개발 목적
- 소설을 읽고 즐기는 주변 사람들을 위해 그들이 원하는 기능을 담은 서비스를 제공.

## 기술 스택
- thymeleaf + springboot + mariadb + JPA + Querydsl

## 인프라
- 웹서버 구현중(리눅스 로컬)..


## 이번 프로젝트를 통해 배울 것.
- 좀 더 유연한 JPA 사용
- ORM에 대한 더 많은 이해 
- 좋은 쿼리를 작성하는 법
- 스프링 시큐리티
- 타임리프
- 로컬에서 웹사이트를 배포하는 과정
- - - - --- - --
***4월 4일 배포 예정***

---------------------

## VM Setting
Vagrant.configure("2") do |config|
  config.vm.define "m-k8s" do |cfg|
    cfg.vm.box = "sysnet4admin/CentOS-k8s"
    cfg.vm.provider "virtualbox" do |vb|
      vb.name = "m-k8s(github_SysNet4Admin)"
      vb.cpus = 2
      vb.memory = 4096
      vb.customize ["modifyvm", :id, "--groups", "/k8s-SM(github_SysNet4Admin)"]
    end
    cfg.vm.host_name = "m-k8s"
    cfg.vm.network "private_network", ip: "192.168.1.10"
    cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true, id: "ssh"
    cfg.vm.synced_folder "../data", "/vagrant", disabled: true
    cfg.vm.provision "shell", path: "install_install_pkg.sh"
  end
end
