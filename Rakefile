namespace :clojure do
  task :run do
    Dir.chdir('clojure') do
      sh("clj -M -m esc.app")
    end
  end

  namespace :test do
    task :run do
      Dir.chdir('clojure') do
        sh("bin/kaocha")
      end
    end
    task :watch do
      Dir.chdir('clojure') do
        sh("bin/kaocha --watch")
      end
    end
  end
end
