namespace :clojure do
  task :run do
    Dir.chdir('clojure') do
      sh("clj -X app/run")
    end
  end

  task :test do
    Dir.chdir('clojure') do
      sh("bin/kaocha")
    end
  end
end
