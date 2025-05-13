1-  Installation de PHP et Composer : # Run as administrator...
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://php.new/install/windows/8.4'))
2 - Installation de l'installateur Laravel : composer global require laravel/installer
3 - Rehefa azo le projet backend de miditra VsCode de tapena ao @ terminal ny : composer install
4- De avy eo : php artisan migrate
5- De avy eo : php artisan db:seed
6- Minstalle Api avy eo : php artisan install:api
7- De avy eo runevana le application : php artisan serve
8- Buildevana fotsn le ao front avec netbeans
